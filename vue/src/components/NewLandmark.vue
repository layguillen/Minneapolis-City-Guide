<template>
  <section id="new-landmark-container">
      <link rel="stylesheet" href='https://fonts.googleapis.com/css?family=Montserrat Alternates'>
      <h2 id="page-title">Submit a New Landmark for Consideration</h2>

      <form class="form" v-on:submit.prevent= "saveLandmark">
          <div class="status-message success" v-show="formAddedSuccess">Review successfully submitted</div> 
        <div class="status-message error" v-show="formAddedFailure">{{errorMessage}}</div>
          <div class="form-group">
            <label for="name">Name</label>
            <input class="form-control" id="name" type= "text" placeholder="Enter Landmark Name" v-model="newLandmark.name">
          </div>
          <div class="form-group">
            <label for="type">Type</label>  
            <select class="form-control" id="type" v-model= "newLandmark.type">
                <option value="">--- Select a type ---</option>
                <option value="5">Amusement</option>
                <option value="1">Art</option>
                <option value="2">Educational</option>
                <option value="7">Historic</option>
                <option value="4">Outdoor</option>
                <option value="8">Restaurant</option>
                <option value="3">Shopping</option>
                <option value="6">Venue</option>
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
                <input type="text" id="state" placeholder="ex: MN" v-model= "newLandmark.state">
              </div>
              <div>
                <label for="zip">Zip Code</label>
                <input type="number" id="zip" placeholder="ex: 55401" v-model= "newLandmark.zip">
              </div>
          </div>
          
          <div>
            <button id="btnAddLandmark" type="submit">Add Landmark</button>
          </div>
      </form>
  </section>
</template>

<script>
import LandmarkService from '../services/LandmarkService'

export default {
    props: {
        id: {
            type: Number,
            default: 0
        }
    },
    data(){
        return {
            newLandmark: {
                name: '',
                type: '',
                description: '',
                street: '',
                city: '',
                state: '',
                zip: ''
            },
            formAddedSuccess: false,
            formAddedFailure: false,
            errorMessage: ''
        }
    },
    methods: {
        saveLandmark(){
            const landmarkToAdd = {
                name: this.newLandmark.name,
                //trying to convert string to number
                type: Number(this.newLandmark.type),
                description: this.newLandmark.description,
                street: this.newLandmark.street,
                city: this.newLandmark.city,
                state: this.newLandmark.state,
                zip: this.newLandmark.zip,
                pending: true
            }
            //if new landmark id is 0, we know it's an insert
            if(this.id === 0){
                LandmarkService.addLandmark(landmarkToAdd)
                .then(response => {
                    //expect a 201 meaning created
                    if(response.status === 201){
                        this.resetForm();
                        this.formAddedSuccess = true;
                        this.$router.push()
                    }
                })
                .catch(error => {
                    this.handleErrorResponse(error, "submitting")
                    this.formAddedFailure = true;
                })
            }
        },
        resetForm(){
          this.newLandmark = {};  
        },
        handleErrorResponse(error, verb) {
            if (error.response) {
                this.errorMessage = '';
                if(error.response.status === 500){
                    this.errorMessage = "Error " + verb + " landmark. An internal server error occurred.";
                } else if (error.response.status === 404){
                    this.errorMessage = "Error " + verb + " landmark. URL could not be found.";
                } else {
                    this.errorMessage = "Error " + verb + " landmark. Response received was '" +
                error.response.statusText +
                "'.";
                }
            } else if (error.request) {
                this.errorMessage = "Error " + verb + " landmark. Server could not be reached.";
            } else {
                this.errorMessage = "Error " + verb + " landmark. Request could not be created.";
            }
        }
            
            
    }
    
}
</script>

<style>

body{
  background-color: #F3FCED;
}

#new-landmark-container {
    border-top: #1fd6c1 5px solid;
    font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial', 'sans-serif';
    color: #004E64;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

h2 {
    text-align: center;
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

#description{
    margin-bottom: 10px;
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
    font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial', 'sans-serif';
    cursor: pointer;
}

.status-message {
  border-radius: 5px;
  font-weight: bold;
  text-align: center;
  padding: 10px;
  width: 350px;
  margin: 0 auto 10px;
}
.status-message.success {
  background-color: #90EE90;
}
.status-message.error {
  background-color: #F08080;
}

</style>