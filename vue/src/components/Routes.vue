<template>
  <div>

  </div>
</template>

<script>
import RouteService from "../services/RouteService"

export default {
    name: "routes",
    data(){

    },
    methods: {
        getRoute(){
            //pass user's selected landmarks into retrieveRoute
            RouteService.retrieveRoute(this.$store.state.itineraryLandmarks)
            .then(response => {
                this.$store.commit('SET_ROUTES', response.data);
            })
            .catch(error => {
                if (error.response && error.response.status === 404) {
                    alert(
                        "Route not available. You may have entered invalid landmark coordinates."
                    );
                    this.$router.push({ name: 'home' });
                }
            });
        },
    }
}
</script>

<style>

</style>