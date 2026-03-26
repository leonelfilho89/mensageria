const amqp = require('amqplib');

async function start() {
  const conn = await amqp.connect('amqp://localhost:1992');
  const channel = await conn.createChannel();

  const filaEntrada = 'fila.teste';
  const filaRetorno = 'fila.retorno';

  await channel.assertQueue(filaEntrada);
  await channel.assertQueue(filaRetorno);

  console.log("Aguardando mensagens...");

  channel.consume(filaEntrada, (msg) => {
    
    const conteudo = JSON.parse(msg.content.toString());

    console.log("Recebido:", conteudo);
    
    // simula processamento
    setTimeout(() => {
      const resposta = {
        pedidoId: conteudo.pedidoId,
        status: "PROCESSADO"
      };

      channel.sendToQueue(
        filaRetorno,
        Buffer.from(JSON.stringify(resposta))
      );

      console.log("Enviado retorno:", resposta);

      channel.ack(msg);
    }, 2000);
  });
}

start();