import React,{useEffect,useState} from "react";
import axios from "axios";

export default function FakePostList(){
const [posts,setPosts]=useState([]);
const load=()=>{axios.get("https://dummyjson.com/posts")
.then(res=>setPosts(res.data.posts));};
useEffect(()=>{load();},[]);
return(<div><h3>Fake Posts</h3>
<button onClick={load}>Refresh</button>
{posts.slice(0,5).map(p=><p key={p.id}>{p.title}</p>)}
</div>);
}
