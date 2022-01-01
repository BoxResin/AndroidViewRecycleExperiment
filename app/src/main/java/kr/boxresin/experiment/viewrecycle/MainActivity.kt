package kr.boxresin.experiment.viewrecycle

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

/** 메인 액티비티 */
class MainActivity : AppCompatActivity() {
    /** 메인 액티비티가 생성될 때 호출된다. */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (contentView == null) {
            contentView = layoutInflater.inflate(R.layout.activity_main, null)
        }

        setContentView(contentView)
    }

    override fun onDestroy() {
        super.onDestroy()
        contentView?.let {
            (it.parent as? ViewGroup)?.removeView(it)
        }
    }

    companion object {
        private var contentView: View? = null
    }
}
