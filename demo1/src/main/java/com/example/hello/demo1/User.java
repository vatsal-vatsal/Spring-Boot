package com.example.hello.demo1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * User Entity Class
 * 
 * This class represents a User entity that maps to the 'user' table in the database.
 * JPA (Java Persistence API) annotations define how this class is stored in database.
 * 
 * @Entity - Marks this class as a JPA entity (database table)
 *   - By default, table name is same as class name: 'user'
 *   - Each field becomes a column in the table
 *   
 * @Data - Lombok annotation that automatically generates:
 *   - Getters and setters for all fields
 *   - toString() method
 *   - equals() and hashCode() methods
 *   - RequiredArgsConstructor
 *   - Reduces boilerplate code significantly
 */
@Entity 
@Data   
public class User {
    
    /**
     * Primary Key - Unique identifier for each user
     * 
     * @Id - Marks this field as primary key
     * @GeneratedValue - Configures auto-generation strategy
     *   IDENTITY: Database auto-inments the ID (MySQL AUTO_INCREMENT)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * User's name field
     * Maps to 'name' column in database
     * No annotation needed - JPA uses field name as column name
     */
    private String name;
    
    /**
     * User's email field
     * Maps to 'email' column in database
     * Could add @Column(unique=true) if emails should be unique
     */
    private String email;
}