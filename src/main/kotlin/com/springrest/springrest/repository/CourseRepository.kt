package com.springrest.springrest.repository

import com.springrest.springrest.entities.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository :  JpaRepository<Course, Long>{

}