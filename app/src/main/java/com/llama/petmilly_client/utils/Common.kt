package llama.test.jetpack_dagger_plz.utils

import android.content.Context
import android.widget.Toast

object Common {
    const val TAG:String = "로그"

    const val LOGINSCREEN:String = "loginScreen"
    const val HOMESCREEN:String = "homeScreen"

    const val SAFESHELTER_COMPOSABLE = "SAFESHELTER_COMPOSABLE"
    const val ANIMALINFO_DETAIL = "ANIMALINFO_DETAIL"

    const val LOCATION_AUTHENTICATION_SCREEN="LocationauthenticationScreen"
    const val PERSONALINFOSCREEN = "PersonalInfoScreen"

    const val CHATSCREEN = "chatscreen"
    const val CHATTINGROOMSCREEN="chattingroomscreen"

    fun MYToast(context:Context,text:String){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

}