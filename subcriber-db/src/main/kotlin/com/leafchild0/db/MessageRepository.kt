package com.leafchild0.db

import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author victor
 * @date 10/29/18
 */
interface MessageRepository : JpaRepository<Message, Long>
