<template>
  <section>
      <form v-on:submit.prevent= "saveReview">
          
      </form>
  </section>
</template>

<script>
export default {

    data(){
        return {
            newReview: {
                title: '',
                description: '',
                liked: false
            }
        }
    },
    methods: {
        saveReview(){
            this.$store.commit('', this.newReview);

            this.newReview = {
                title: '',
                description: '',
                liked: false
            }
        }
    }

}
</script>

<style>

</style>