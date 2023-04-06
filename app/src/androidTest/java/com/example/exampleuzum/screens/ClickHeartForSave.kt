package com.example.exampleuzum.screens

import android.view.View
import com.example.exampleuzum.FullProductAdapter
import com.example.exampleuzum.R
import com.kaspersky.components.kautomator.component.check.UiCheckBox
import com.kaspersky.components.kautomator.screen.UiScreen
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

object ClickHeartForSave : UiScreen<ClickHeartForSave>() {

    override val packageName: String = "com.example.exampleuzum"
    val wishButton = UiCheckBox { withId(this@ClickHeartForSave.packageName, "checkBoxInFrameWithImageView") }
    val recyclerForWish: KRecyclerView = KRecyclerView({
        withId(R.id.recycler_view_in_frgpopular)
    }, itemTypeBuilder = {
        itemType(ClickHeartForSave::RecyclerItem)
    })
    class RecyclerItem(parent: Matcher<View>) : KRecyclerItem<RecyclerItem>(parent) {
        val firstSwatch = KTextView(parent) { withId(R.id.recyclerImTired) }
    }
}
