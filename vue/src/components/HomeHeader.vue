<template>
  <div class="home-header">
    <div id="header" class="home-element">
      <div id="title-img">
        <h1 id="title">Glider</h1>
        <img id="glider-img" src="..\assets\Glider-1.png" alt="Glider Image" >
      </div>
      <router-link v-bind:to="{name: 'addLandmark'}">
        <button id="addLandmark">Suggest a Landmark</button>
      </router-link>
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
  align-items: center;
}

#addLandmark{
  border: 5px solid;
  padding: 8px;
  background-color: #004E64;
  color: #F3FCED;
  border-radius: 12px;
  justify-content: center;
  align-content: center;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', 'Arial', 'sans-serif';
}

</style>