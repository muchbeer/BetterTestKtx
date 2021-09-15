package raum.muchbeer.bettertestktx.testutil

import android.content.Context

class ResourceComparer() {

    fun equalSign(context: Context, resId: Int, string: String) : Boolean{
       return context.getString(resId) == string
    }
}