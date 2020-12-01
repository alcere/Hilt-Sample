package poc.android.hilt

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import poc.android.hilt.dependencies.Appliance
import poc.android.hilt.dependencies.Microwave
import poc.android.hilt.dependencies.QuickMixer
import poc.android.hilt.di.ApplianceModule
import poc.android.hilt.di.MixerModule

@HiltAndroidTest
@UninstallModules(MixerModule::class, ApplianceModule::class)
class BakeryActivityTest {

    private var hiltRule = HiltAndroidRule(this)

    private var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    var rule = RuleChain.outerRule(hiltRule).around(activityRule)

    @BindValue
    @JvmField
    val appliance: Appliance = Microwave()

    // We are using a test module, so we do not need this
//    @BindValue
//    @JvmField
//    val mixer: Mixer = QuickMixer()

    @Test
    fun `Test_activity_shows_text`() {
        val expectedText = CakeProducer.TEXT.format(QuickMixer.SPEED, Microwave.TIME)
        onView(withId(R.id.bakery_text))
            .check(ViewAssertions.matches(withText(expectedText)))
    }
}
