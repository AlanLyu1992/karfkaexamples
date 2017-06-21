package karfkaexamples;

import java.util.Properties;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProducer {
	public static void main(String[] args){
		Properties properties = new Properties();
		
		//kafka bootstrap server
		properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
		//producer acks
		properties.setProperty("key.serializer", StringSerializer.class.getName());
		properties.setProperty("value.serializer", StringSerializer.class.getName());
		properties.setProperty("acks", "1");
		properties.setProperty("retries", "3");
		
		Producer<String,String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String,String>(properties);
		//topic name
		
		ProducerRecord<String,String> producerRecord = new ProducerRecord<String,String>("second_topic","3","Here comes Alan Lyu!!");
		producer.send(producerRecord);
		producer.close();
		
	}
}
