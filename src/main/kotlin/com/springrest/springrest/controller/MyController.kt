package com.springrest.springrest.controller

import com.springrest.springrest.entities.Course
import com.springrest.springrest.services.CourseService
import com.springrest.springrest.services.CourseServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux

@RestController
class MyController {

    @Autowired
    val courseService = CourseServiceImpl();

    @GetMapping("/home")
    fun homePage(): String {
        return "hello world"
    }

//    @GetMapping("/courses2")
//    fun getCourses2(): Flux<Course> {
////        val courseServiceImpl = CourseServiceImpl();
////        val courseService = CourseService();
//        return
//        return courseService.getCourses()
//    }

//    @GetMapping(path = ["/flux"], produces = [MediaType.ALL_VALUE])
//    @ResponseBody
//    fun getNumbers(): Flux<Int> = Flux.range(1, 100);

//    @GetMapping("/courses/{courseId}")
//    fun getCourseViaId(): Course{
//        return courseService.getCourseViaId(courseId)
//    }

    @GetMapping("/courses")
    fun getCourses(): List<Course> {
//        val courseServiceImpl = CourseServiceImpl();
//        val courseService = CourseService();
        return this.courseService.getCourses()
    }

    @GetMapping("/courses/{courseId}")
    fun getCourseVidId(@PathVariable courseId: Long): Course? {
        return this.courseService.getCourseViaId(courseId);
    }

    @PostMapping("/courses")
    fun addCourses(@RequestBody course: Course): String {
        return this.courseService.addCourse(course)
    }

    @PutMapping("/courses")
    fun updateCourse(@RequestBody updatedCourse: Course): String {
        return this.courseService.updateCourse(updatedCourse)
    }

    @DeleteMapping("/courses/{courseId}")
    fun deleteCourse(@PathVariable courseId: Long): String{
        return this.courseService.deleteCourse(courseId);
    }
    
    @GetMapping("/error")
    fun errormsg(): ResponseEntity<HttpStatus> {
        val flag : Boolean = false;
        return if(flag) {
            ResponseEntity(HttpStatus.OK)
        }  else {
            ResponseEntity(HttpStatus.BAD_GATEWAY)
        }
    }
}