<template>
  <section id="main">
      <h2 id="page-title">Submit a New Landmark for Consideration</h2>

      <form class="form" v-on:submit.prevent= "saveLandmark">
          <div class="form-group">
            <label for="name">Name</label>
            <input class="form-control" id="name" type= "text" placeholder="Enter Landmark Name" v-model="newLandmark.name">
          </div>
          <div class="form-group">
            <label for="type">Type</label>  
            <select class="form-control" id="type" v-model= "newLandmark.type">
                <option value="">--- Select a type ---</option>
                <option value="Amusement">Amusement</option>
                <option value="Art">Art</option>
                <option value="Educational">Educational</option>
                <option value="Historic">Historic</option>
                <option value="Outdoor">Outdoor</option>
                <option value="Restaurant">Restaurant</option>
                <option value="Shopping">Shopping</option>
                <option value="Venue">Venue</option>
            </select>
          </div>
          <div class="form-group">
            <label for="description">Description</label>
            <textarea class="form-control" id="description" rows="3" v-model= "newLandmark.description"></textarea>
          </div>    
          <!-- <div class="form-group">
              <label for="imgURL">Image URL</label>
              <input class="form-control" id="imgURL" type= "url" placeholder="Landmark Image URL" v-model= "newLandmark.imgUrl">
          </div> -->
          
          <label id="addressLabel" for="address">Landmark Address:</label>
          <div id="address" class="form-group">
              <div>
                <label for="street">Street</label>
                <input id="street" type="text" placeholder="street" v-model= "newLandmark.street">
              </div>
              <div>
                <label for="city">City</label>
                <input type="text" id="city" placeholder="city" v-model= "newLandmark.city">
              </div>
              <div>
                <label for="state">State Abbreviation (ex: MN)</label>
                <input type="text" id="state" placeholder="state abbreviation" v-model= "newLandmark.state">
              </div>
              <div>
                <label for="zip">Zip Code</label>
                <input type="number" id="zip" placeholder="zip code" v-model= "newLandmark.zip">
              </div>
          </div>
          
          <div>
            <button id="btnAddLandmark" type="submit">Add Landmark</button>
          </div>
      </form>
  </section>
</template>

<script>
export default {
    data(){
        return {
            newLandmark: {
                name: '',
                type: '',
                description: '',
                street: '',
                city: '',
                state: '',
                zip: '',
                approved: false
            }
        }
    },
    methods: {
        saveTodo(){
            this.newLandmark.approved = false;
            // make a pending landmark array in store
            this.$store.commit('SET_PENDING_LANDMARKS', this.newLandmark);
            
            // resets the form to blank
            this.newLandmark = {
                name: '',
                type: '',
                description: '',
                street: '',
                city: '',
                state: '',
                zip: '',
                approved: false
            }
        }
    }
}
</script>

<style>

body{
  background-color: #F3FCED;
}

#main {
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', 'Arial', 'sans-serif';
    color: #004E64;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

h2 {
    text-align: center;
}

.form-group {
    /* margin: 1rem 0;
    display: flex;
    flex-direction: column;
    justify-content: space-around; */

    /* margin-top: 1.5rem;
    margin-bottom: 1.5rem; */
}

.form {
    display: flex;
    flex-direction: column;
    width: 500px;
    margin: 20px;
}

.form div {
    display: flex;
    justify-content: center;
    align-content: center;
    
}

#addressLabel{
    margin-top: 10px;
    text-align: center;
    font-weight: bold;
}

#address {
    display: block;
    text-align: center;
}

#address div{
    padding: 5px;
}

#address div label{
    margin-right: 10px;
}

#btnAddLandmark{
    /* margin-top: 2%;
    margin-left: 10%;
    margin-right: 10%; */
    padding: 10px;
    background-color: #004E64;
    border-radius: 12px;
    color: #F3FCED;
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', 'Arial', 'sans-serif';
}

</style>