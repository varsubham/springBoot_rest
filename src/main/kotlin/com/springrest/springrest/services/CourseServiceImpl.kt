package com.springrest.springrest.services

import com.springrest.springrest.entities.Course
import com.springrest.springrest.repository.CourseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CourseServiceImpl : CourseService{
//    var courseList = mutableListOf<Course>();

    @Autowired
    private lateinit var courseRepository: CourseRepository;

    init {
//        val course1 = Course(1234, "Math", 4)
//        val course2 = Course(34, "Computer Science", 8)
//        val course3 = Course(89, "Dissertation", 16)
//        courseList.add(course1)
//        courseList.add(course2)
//        courseList.add(course3)
    }
    override fun getCourses(): List<Course> {
//        return courseList;
        return courseRepository.findAll()
    }

    override fun getCourseViaId(courseId: Long): Course? {
//        var course2: Course? = null;
//        for(course in courseList){
//            if(course.ID == courseId) {
//                course2 = course
//                break;
//            }
//        }
//        return course2;
        return courseRepository.getById(courseId);
    }

    override fun addCourse(course: Course): String {
//        if(course != null){
//            courseList.add(course)
//            return "Added course"
//        }
//        return "Not Added course"

        courseRepository.save(course)
        return "added"
    }

    override fun updateCourse(updatedCourse: Course): String {
        try{
            courseRepository.save(updatedCourse)
            return "updated"
        } catch (e: Exception) {
            return "Not updated"
        }
    }

    override fun deleteCourse(courseId: Long): String {

//        var flag: Boolean = false
//        courseList.forEachIndexed{index, course ->
//            if(course.ID == courseId){
//                courseList.removeAt(index)
//                flag = true
//            }
//        }
//        return if(flag){
//            "Deleted"
//        } else {
//            "Not Deleted"
//        }
        try{
            val course: Course = courseRepository.getById(courseId);
            courseRepository.delete(course);
            return "deleted"
        }
        catch(e: Exception){
            return "Not deleted"
        }
    }
}