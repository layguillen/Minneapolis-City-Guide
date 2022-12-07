<template>
  <div class="home-header">
    <div id="header" class="home-element">
      <div id="title-img">
        <h1 id="title">Glider</h1>
        <img id="glider-img" src="..\assets\Glider-1.png" alt="Glider Image" >
      </div>
      <router-link id="addLandmark" v-bind:to="{name: 'addLandmark'}">Add a Landmark</router-link>
      <!-- <h2 id="add-landmark">Add a Landmark</h2> -->
    </div>
   </div>
</template>

<style>

#title-img {
  display: flex;
}

#title {
  align-self: center;
}

#glider-img {
  display: inline-block;
  height: 4.8em;
}

#header {
  display: flex;
  justify-content: space-between;
}

#addLandmark{
  border: 5px #004E64 solid;
  border-radius: 10%;
  justify-content: center;
  align-content: center;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', 'Arial', 'sans-serif';
}

</style>