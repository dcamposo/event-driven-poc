package br.com.zup.payment.listner;

import br.com.zup.payment.event.BookedEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;

@Configuration
@EnableKafka
public class KafkaListner {

    private ObjectMapper objectMapper;

    @Autowired
    public KafkaListner(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "booked-orders", groupId = "payment-group-id")
    public void listenCreatedOrders(String message) throws IOException {
        BookedEvent event = this.objectMapper.readValue(message, BookedEvent.class);
        System.out.println("evento: " + event);
    }

}
