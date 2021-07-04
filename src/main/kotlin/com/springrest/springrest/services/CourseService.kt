package com.springrest.springrest.services

import com.springrest.springrest.entities.Course
import kotlin.collections.List as List1

interface CourseService {
    fun getCourses(): List1<Course>;
    fun getCourseViaId(courseId: Long): Course?;
    fun addCourse(course: Course): String;
    fun updateCourse(updatedCourse: Course): String;
    fun deleteCourse(courseId: Long) : String;
}