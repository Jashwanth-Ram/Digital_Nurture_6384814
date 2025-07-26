
import React from 'react';
import './App.css';

import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';
import { books,blogs,courses } from './assets';
import BookDetails from './components/BookDetails';

function App() {
  const bookdet   = <BookDetails   books={books}/>;
  const content   = <BlogDetails   blogs={blogs}/>;
  const coursedet = <CourseDetails  courses={courses}/>;

  return (
    <div className="App">
      <div className="details‑wrapper">
        <div className="st2">
          <h1>Book Details</h1>
          {bookdet}
        </div>

        <div className="v1">
          <h1>Blog Details</h1>
          {content}
        </div>

        <div className="mystyle1">
          <h1>Course Details</h1>
          {coursedet}
        </div>
      </div>
    </div>
  );
}

export default App;
