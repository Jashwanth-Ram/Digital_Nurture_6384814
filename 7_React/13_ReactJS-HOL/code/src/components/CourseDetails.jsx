
import React from 'react';

const CourseDetails = ({ courses }) => (
  <div>
    <h2>Course Details</h2>
    <ul>
      {courses.map(course => (
        <li key={course.id}>
          <strong>{course.name}</strong><br/>
          <small>{course.date}</small>
        </li>
      ))}
    </ul>
  </div>
);

export default CourseDetails;
