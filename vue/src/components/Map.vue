<template>
  <div>
      <h2>Minneapolis Map</h2>
      <div class="map">
          <iframe width="425" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://www.openstreetmap.org/export/embed.html?bbox=-93.40061187744142%2C44.88263391919232%2C-93.20835113525392%2C45.05872899067149&amp;layer=mapnik" style="border: 1px solid black"></iframe><br/><small><a href="https://www.openstreetmap.org/#map=12/44.9707/-93.3045">View Larger Map</a></small>
      </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>

h2 {
color: #004E64;
font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial', 'sans-serif';
}

.map{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

</style>