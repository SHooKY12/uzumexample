package dataclassesForUse

class ListsForSaveSelectedAndLookedProducts {
    companion object {
        var listForSAveCategories: MutableList<Product> = mutableListOf()
        fun addModel(model: Product) {
            listForSAveCategories.add(model)
        }
        fun removeModel(model: Product) {
            listForSAveCategories.remove(model)
        }
    }
}

