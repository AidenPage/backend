package com.computerstore.backend.domain.components;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Aiden on 2016/10/23.
 */
@Entity
public class Processor  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Name;
    private String Description;
    private String Stock;
    private String Price;

    private Processor(){
    }

    private Processor(Builder builder) {
        this.id = builder.id;
        this.Name = builder.Name;
        this.Description = builder.Description;
        this.Stock = builder.Stock;
        this.Price = builder.Price;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public String getStock() {
        return Stock;
    }

    public String getPrice() {
        return Price;
    }

    public static class Builder {

        private long id;
        private String Name;
        private String Description;
        private String Stock;
        private String Price;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder name(String val) {
            this.Name = val;
            return this;
        }

        public Builder description(String val) {
            this.Description = val;
            return this;
        }

        public Builder stock(String val) {
            this.Stock = val;
            return this;
        }


        public Builder price(String val) {
            this.Price = val;
            return this;
        }

        public Builder copy(Processor processor) {
            this.id = processor.id;
            this.Name = processor.Name;
            this.Description = processor.Description;
            this.Stock = processor.Stock;
            this.Price = processor.Price;
            return this;
        }

        public Processor build() {
            return new Processor(this);
        }

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}
