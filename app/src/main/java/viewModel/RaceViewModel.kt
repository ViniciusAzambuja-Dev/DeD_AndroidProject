package viewModel

import androidx.lifecycle.ViewModel
import com.example.ded.data.RacesDAO
import com.example.ded.entity.RaceEntity

class RaceViewModel(private val racesDAO: RacesDAO) : ViewModel() {

    suspend fun deleteRace(raceId : Int){
        racesDAO.deleteRaceById(raceId)
    }
}