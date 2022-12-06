<template>
  <div class="home">
    <div id="header">
      <h1 id="title">Glider</h1>
      <img id="glider-img" src="..\assets\Glider-1.png" alt="Glider Image" >
    </div>
    <div id="filter">
      <h2 id="filter-names">Example</h2>
    </div>
    <div id="main">
      <h3 id="example">Another</h3>
    </div>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style>

body {
  height: 100%;
  width: 100%;
  margin: 0;
}

div.home {
  display: grid;
  grid-template-areas: 
  "header"
  "filter"
  "main";
  grid-template-rows: .1fr .1fr 1fr;
}

#title {
  display: inline-block;
}

#glider-img {
  height: 10%;
}

#header {
  grid-area: header;
}

#filter {
  grid-area: filter;
}

#main {
  grid-area: main;
}

</style>