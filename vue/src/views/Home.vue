<template>
  <div class="home">
    <HomeHeader></HomeHeader>
    <div id="filter" class="home-element">
      <h2 id="filter-names">Example</h2>
    </div>
    <div id="main" class="home-element">
      <h3 id="example">Another</h3>
    </div>
  </div>
</template>

<script>
import HomeHeader from "../components/HomeHeader.vue";

export default {
  name: "home",
  components: {
    HomeHeader
}
};
</script>

<style>

body {
  height: 100vh;
  width: 100vw;
  margin: 0;
}

div.home {
  display: grid;
  grid-template-areas: 
  "header"
  "filter"
  "main";
  grid-template-rows: .1fr .1fr 1fr;
  height: 100vh;
  width: 100vw;
  margin: 0;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', 'Arial', 'sans-serif';
}

#filter {
  grid-area: filter;
  border-top: #1fd6c1 5px solid;
}

#main {
  grid-area: main;
}

.home-element {
  padding-right: 5%;
  padding-left: 5%;
}

</style>