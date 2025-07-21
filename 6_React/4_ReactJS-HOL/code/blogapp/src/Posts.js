import React from "react";
import axios from "axios";

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false
    };
  }

  async loadPosts() {
    try {
      const response = await axios.get("https://jsonplaceholder.typicode.com/posts");
      this.setState({ posts: response.data });
    } catch (error) {
      console.error("Error fetching posts:", error);
    }
  }

  componentDidMount() {
    this.loadPosts();
  }


  componentDidCatch(error, info) {
    this.setState({ hasError: true });
    alert("Something went wrong: " + error.message);
    console.error("Caught by componentDidCatch:", error, info);
  }

  render() {
    if (this.state.hasError) {
      return <h2>Something went wrong while rendering the posts.</h2>;
    }

    const { posts } = this.state;

    return (
      <div style={{ padding: '20px' }}>
        <h2>Post List</h2>
        {posts.length === 0 ? (
          <p>Loading posts...</p>
        ) : (
          posts.map((post) => (
            <div key={post.id} style={{ marginBottom: '20px', borderBottom: '1px solid #ccc', paddingBottom: '10px' }}>
              <h3 style={{ color: 'darkblue' }}>{post.title}</h3>
              <p>{post.body}</p>
            </div>
          ))
        )}
      </div>
    );
  }
}

export default Posts;
