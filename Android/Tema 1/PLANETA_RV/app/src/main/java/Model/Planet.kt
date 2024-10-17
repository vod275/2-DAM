package Model

class Planet(val name: String, val sizeKM: Int, val DistanceAU: Double, val imageName: String = name.lowercase()) {
}