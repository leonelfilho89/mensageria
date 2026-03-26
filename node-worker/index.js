const amqp = require('amqplib');

async function connectWithRetry() {
  try {
    const conn = await amqp.connect('amqp://rabbit:5672');
    console.log("Conectado ao Rabbit!");

    const channel = await conn.createChannel();
    const filaEntrada = 'fila.teste';
    const filaRetorno = 'fila.retorno';

    await channel.assertQueue(filaEntrada);
    await channel.assertQueue(filaRetorno);

    console.log("Aguardando mensagens...");

    channel.consume(filaEntrada, (msg) => {
      const conteudo = JSON.parse(msg.content.toString());

      console.log("Recebido:", conteudo);

      const resposta = {
        pedidoId: conteudo.pedidoId,
        status: "PROCESSADO"
      };

      channel.sendToQueue(
        filaRetorno,
        Buffer.from(JSON.stringify(resposta))
      );

      channel.ack(msg);
    });

  } catch (err) {
    console.log("Rabbit não disponível, tentando novamente em 5s...");
    setTimeout(connectWithRetry, 5000);
  }
}

connectWithRetry();