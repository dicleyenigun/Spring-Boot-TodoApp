import  React, { useEffect, useState } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@mui/material';

export default function TodoList() {
    const paperStyle={padding: '50px 20px', width:600, margin:"20px auto"}
    const[name,setName]=useState('')
    const[address,setAddress]=useState('')
    const[todoLists,setTodoLists] = useState([])
    const handleClick=(e)=>{ 
        e.preventDefault()
        const todoList={name,address}
        console.log(todoList) 
        fetch("https://localhost:8000/todoList/add",{
          method:"POST",
          headers:{"Content-Type":"application/java"},
          body:JSON.stringify(todoList) 
        }).then(()=>{
          console.log("New Article added")
        })
    }

    useEffect(()=>{
      fetch("https://localhost:8080/todoList/getAll")
      .then(res=>res.json())
      .then((result)=>{
        setTodoLists(result);
      }
    )    
  },[])

  return (
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1,  },
      }}
      noValidate
      autoComplete="off"
    >
        <Container>
            <Paper elevation={3} style={paperStyle}>

            <h1 style = {{color:"blue"}}><u> To do list </u></h1> 

            <TextField id="outlined-basic" label="List Name" variant="outlined" fullWidth 
            value={name}
            onChange={(e)=>setName(e.target.value)}
            />
            <TextField id="outlined-basic" label="List Content" variant="outlined" fullWidth 
            value={address}
            onChange={(e)=>setAddress(e.target.value)} 
            />

        <Button variant="contained" onClick={handleClick }> Submit </Button>  

        
      </Paper>

      <h1>Articles</h1>
      <Paper elevation={3} style={paperStyle}> 

        {todoLists.map(todoList=>(
          <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={todoList.id}>
            Id:{todoList.id}
            Name:{todoList.name} <br/>
            Address:{todoList.address}
            </Paper> 
        ))}


      </Paper>
      </Container>
    </Box>
  );
}
