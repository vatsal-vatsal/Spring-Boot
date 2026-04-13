package com.example.hello.demo1;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User Repository Interface
 * 
 * This interface extends JpaRepository, which provides database operations for User entity.
 * Spring Data JPA automatically creates implementation at runtime.
 * 
 * JpaRepository<Entity, ID> provides:
 *   - Basic CRUD operations: save(), findById(), findAll(), delete(), etc.
 *   - Pagination support: findAll(Pageable pageable)
 *   - Sorting support: findAll(Sort sort)
 *   - Query derivation from method names
 * 
 * No implementation needed - Spring creates it automatically!
 */
public interface UserRepository extends JpaRepository<User, Long> {
    
    // That's it! Spring automatically provides:
    // - save(User user) - Save or update user
    // - findById(Long id) - Find user by ID
    // - findAll() - Get all users
    // - deleteById(Long id) - Delete user by ID
    // - count() - Count total users
    // - existsById(Long id) - Check if user exists
    // Plus many more methods...
}