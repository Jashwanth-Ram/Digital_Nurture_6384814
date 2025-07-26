
import React from 'react';

const BlogDetails = ({ blogs }) => (
  <div>
    <h2>Blog Details</h2>
    {blogs.map(blog => (
      <div key={blog.id} style={{ marginBottom: '1.5rem' }}>
        <h3>{blog.title}</h3>
        <h4 style={{ fontStyle: 'italic' }}>{blog.author}</h4>
        <p>{blog.content}</p>
      </div>
    ))}
  </div>
);

export default BlogDetails;
