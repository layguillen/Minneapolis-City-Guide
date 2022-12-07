<template>
<div class="home-header">
     <link rel="stylesheet" href='https://fonts.googleapis.com/css?family=Montserrat Alternates'>
    <div id="header" class="home-element">
      <div id="title-img">
        <h1 id="title">Glider</h1>
        <img id="glider-img" src="..\assets\Glider-1.png" alt="Glider Image" >
      </div>
      <router-link v-bind:to="{name: 'addLandmark'}">
        <button id="addLandmark">Add Landmark</button>
      </router-link>
<<<<<<< HEAD
=======
      
>>>>>>> af7ac8d356b4c0de339d78cd451ebaca8592d11b
    </div>
    
   </div>


</template>

<style>


#title-img {
  display: flex;
}

#title {
  align-self: center;
  font-family: 'Montserrat Alternates';
  color: #129D8D;
}

#glider-img {
  display: inline-block;
  height: 4.8em;
}

#header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
}

#addLandmark{
  border: 5px solid;
  padding: 8px;
  background-color: #004E64;
  color: #F3FCED;
  border-radius: 12px;
  justify-content: center;
  align-content: center;
<<<<<<< HEAD
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
=======
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', 'Arial', 'sans-serif';
  cursor: pointer;
>>>>>>> af7ac8d356b4c0de339d78cd451ebaca8592d11b
}

</style>