package amilosevic.and.anovinc.ferit.temperatureprediction.ui.dialog

import amilosevic.and.anovinc.ferit.temperatureprediction.databinding.ResultDialogBinding
import amilosevic.and.anovinc.ferit.temperatureprediction.ui.viewmodels.MainActivityViewModel
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResultDialog : DialogFragment() {

    private lateinit var binding: ResultDialogBinding
    private val viewModel by viewModel<MainActivityViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = ResultDialogBinding.inflate(layoutInflater).also {

            it.tvResult.text = arguments?.getString("temp")

            it.btnOk.setOnClickListener {
                dismiss()
            }
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels)
        val height = (resources.displayMetrics.heightPixels * 0.5).toInt()

        dialog!!.window?.setLayout(width, height)
    }
}