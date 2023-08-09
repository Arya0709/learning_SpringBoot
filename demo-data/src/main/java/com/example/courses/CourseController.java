package com.example.courses;

import com.example.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService CourseService;
    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){
        return CourseService.getAllCourses(id);
    }
    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id){
        return CourseService.getCourse(id);
    }
    //method called when there is a post request
    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")  //configured and mapped post for post request
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        CourseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")  //configured and mapped post for post request
    public void updateCourse(@RequestBody Course course,@PathVariable String topicId, @PathVariable String id){
        course.setTopic(new Topic(topicId,"",""));
        CourseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        CourseService.deleteCourse(id);
    }
}
