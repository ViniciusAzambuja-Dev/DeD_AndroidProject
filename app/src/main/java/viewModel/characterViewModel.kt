package viewModel

import androidx.lifecycle.ViewModel
import characterModule.characterPackage.Character

class characterViewModel : ViewModel() {
    var character: Character? = null
}