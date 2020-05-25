<template>
  <div class="myNavBar">
    <b-button v-b-toggle.sidebar-variant>Menu</b-button>
    <b-sidebar id="sidebar-variant" title="Menu" bg-variant="dark" text-variant="light" shadow>
      <div class="px-3 py-2">
        <nav class="mb-3">
            <b-nav vertical>
                <b-nav-item href="/#" @click="hide">Home</b-nav-item>
                <b-nav-item href="#link-2" @click="hide">Emergencias</b-nav-item>
                <b-nav-item href="#link-2" @click="hide">Tareas</b-nav-item>
                <b-nav-item-dropdown
                    id="my-nav-dropdown"
                    text="Voluntarios"
                    toggle-class="nav-link-custom"
                    >
                    <b-dropdown-item>Segun Habilidad</b-dropdown-item>
                    <b-dropdown-item>Segun Emergencia</b-dropdown-item>
                    <b-dropdown-divider></b-dropdown-divider>
                    <b-dropdown-item>Three</b-dropdown-item>
                </b-nav-item-dropdown>
                <b-nav-item href="/about" @click="hide">About us</b-nav-item>

            </b-nav>
          </nav>
      </div>
    </b-sidebar>
  </div>
</template>