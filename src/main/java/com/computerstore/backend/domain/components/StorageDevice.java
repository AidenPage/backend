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
public class StorageDevice  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Name;
    private String Description;
    private String Stock;
    private String Price;

    private StorageDevice(){
    }

    private StorageDevice(Builder builder) {
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

        public Builder copy(StorageDevice storageDevice) {
            this.id = storageDevice.id;
            this.Name = storageDevice.Name;
            this.Description = storageDevice.Description;
            this.Stock = storageDevice.Stock;
            this.Price = storageDevice.Price;
            return this;
        }

        public StorageDevice build() {
            return new StorageDevice(this);
        }

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}
