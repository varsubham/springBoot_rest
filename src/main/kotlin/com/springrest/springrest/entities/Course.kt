package com.springrest.springrest.entities

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Course(@Id val ID: Long, val name: String, val credits: Int) {


}