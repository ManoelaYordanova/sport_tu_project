<template>
  <div class = "sports">
    <IconsSports />
    <b-container>
      <b-table class = 'table'
               striped hover
               :items="content"
               :fields="fields"
               fixed
               dark
               bordered>
      </b-table>
    </b-container>
  </div>
</template>

<script>
import IconsSports from '../components/IconsSports'
import SportsServices from '../services/sport_service.js'
export default {
  name: 'Sports',
  components: {
    IconsSports
  },
  data () {
    return {
      content: [{ id: '', name: '', day: '', time: '' }],
      fields: [
        { key: 'name', label: 'Име' },
        { key: 'day', label: 'Ден' },
        { key: 'time', label: 'Начален час' }
      ]
    }
  },
  mounted () {
    SportsServices.getAllSports().then(
      response => {
        console.log(response)
        this.content = response.data
      },
      error => {
        this.content =
          (error.response && error.response.data) ||
          error.message ||
          error.toString()
      }
    )
  }
}
</script>
<style scoped>
.sports {
  padding-top: 80px;
  padding-bottom: 80px;
  background-image: url("../assets/back.jpg");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
  font-weight: bold;
}
.table {
  background-image: url("../assets/table.jpg");
  background-size: cover;
  color: white;
}
</style>
