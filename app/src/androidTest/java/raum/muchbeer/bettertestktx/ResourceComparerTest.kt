package raum.muchbeer.bettertestktx

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.runner.RunWith

import raum.muchbeer.bettertestktx.testutil.ResourceComparer

@RunWith(AndroidJUnit4::class)
class ResourceComparerTest {

    private lateinit var resourceComparer: ResourceComparer

    @Before
    fun setUp() {
      resourceComparer = ResourceComparer()
    }
    @Test
    fun test_stringInResource_stringGiven() {
        val applicaContent = ApplicationProvider.getApplicationContext<Context>()
        val comparer = resourceComparer.equalSign(applicaContent, R.string.testing,"Test")

     assertEquals(true, comparer)
      //  assertThat(comparer).isTrue()

    }
}