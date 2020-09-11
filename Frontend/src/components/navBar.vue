<template>
  <div class="myNavBar" >
    <b-navbar type="dark" variant="dark" style="margin-bottom: 70px;">
    <b-navbar-nav>
      <b-nav-item to="/">Home</b-nav-item>

      <!-- Navbar dropdowns -->
      <b-nav-item-dropdown text="Emergencias" right>
        <b-dropdown-item to="/emergencia">Todas las Emergencias</b-dropdown-item>
      </b-nav-item-dropdown>

      <b-nav-item-dropdown text="Tareas" right>
        <b-dropdown-item href="#">Todas las Tareas</b-dropdown-item>
      </b-nav-item-dropdown>

      <b-nav-item-dropdown text="Voluntarios" right>
        <b-dropdown-item to="/voluntario">Todos los Voluntarios</b-dropdown-item>
        <b-dropdown-item to="/voluntarios/habilidad">Segun Habilidad</b-dropdown-item>
        <b-dropdown-item to="/voluntarios/emergencia">Segun Emergencia</b-dropdown-item>
      </b-nav-item-dropdown>

      <b-nav-item-dropdown text="Habilidad" right>
        <b-dropdown-item to="/habilidad">Todos las Habilidades</b-dropdown-item>
      </b-nav-item-dropdown>

      
    </b-navbar-nav>
  </b-navbar>
  </div>
</template>