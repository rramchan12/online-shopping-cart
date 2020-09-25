package com.ravi.onlineshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Entity Class Representing a Customer
 */
@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    long customer_id;
    String first_name;
    String last_name;
    String add1;
    String add2;
    String  dob;
    String email;


}


