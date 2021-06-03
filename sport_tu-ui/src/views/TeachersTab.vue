<template>
  <div class="teachersTab">
    <h1>
      {{teachers.firstName}} {{teachers.lastName}}
    </h1>
    <h2>
      <b-container>
        {{teachers.characteristic}}
      </b-container>
    </h2>
  </div>
</template>

<script>
import TeacherServices from '../services/teachers-service.js'
export default {
  name: 'TeachersTab',
  data () {
    return {
      teachers: {
        id: '',
        firstName: '',
        lastName: '',
        email: '',
        characteristic: ''
      }
    }
  },
  beforeRouteEnter (to, from, next) {
    if (to.params.id) {
      TeacherServices.findById(to.params.id).then(
        responce => {
          next(vm => vm.setData(responce)
          )
        }
      )
    } else {
      next()
    }
  },
  methods: {
    setData (responce) {
      this.teachers = responce.data
    }
  }
}
</script>

<style scoped>
.teachersTab {
  padding-top: 80px;
  padding-bottom: 700px;
  font-weight: bold;
  background-image: url("../assets/m8.jpg");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
  font-style: italic;
  color: white;
}
</style>
