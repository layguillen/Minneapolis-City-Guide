<template>
  <section>
      <form v-on:submit.prevent= "saveReview">
          <div class="form-element">
            <label for="reviewer">Username:</label>
            <input id="reviewer" type="text" v-model="newReview.username" />
        </div>
        <div class="form-element">
            <label for="title">Title:</label>
            <input id="title" type="text" v-model="newReview.title" />
        </div>
        <div class="form-element">
            <label for="rating">Rating:</label>
            <select id="rating" v-model="newReview.rating">
                <option value="">--- Select Rating ---</option>
                <option value="true">Liked</option>
                <option value="false">Disliked</option>
            </select>
        </div>
        <div class="form-element">
            <label for="review">Review</label>
            <textarea id="review" v-model="newReview.review"></textarea>
        </div>
        <div class="actions">
            <button v-on:click="resetForm" type="button">Cancel</button>
            <button>Submit</button>
        </div>
      </form>
  </section>
</template>

<script>
import ReviewService from '../services/ReviewService';

export default {
    name: "review-form",
    props: {
        reviewID: {
            type: Number,
            default: 0
        }
    },
    data(){
        return {
            newReview: {
                landmarkID: 0,
                username: '',
                title: '',
                description: '',
                liked: false
            }
        }
    },
    methods: {
        saveReview(){
            const reviewToAdd = {
                landmarkID: Number(this.$route.params.id),
                username: this.newReview.username,
                title: this.newReview.title,
                description: this.newReview.description,
                liked: this.newReview.liked
            };
            //if it's a zero we know it's an insert
            if(this.reviewID === 0){
                //add
                ReviewService.addReview(this.newReview)
                .then(response => {
                    //expect a 201 meaning created
                    if(response.status === 201){
                        this.$router.push(`landmarkDetails/${this.newReview.landmarkID}`)
                    }
                })
                .catch(error => {
                    this.hand
                })
            }

            this.$store.commit('', this.newReview);
            this.$router.push({name: 'landmarkDetails', params:{id: landmarkID}})
            //resets form 
            this.newReview = {
                username: '',
                title: '',
                description: '',
                liked: false
            }
        }, 
        resetForm(){
            this.newReview = {};
        },
        handleErrorResponse(error, verb) {
            if (error.response) {
                this.errorMsg =
                "Error " + verb + " card. Response received was '" +
                error.response.statusText +
                "'.";
            } else if (error.request) {
                this.errorMsg =
                "Error " + verb + " card. Server could not be reached.";
            } else {
                this.errorMsg =
                "Error " + verb + " card. Request could not be created.";
            }
        }
    }

}
</script>

<style>

</style>