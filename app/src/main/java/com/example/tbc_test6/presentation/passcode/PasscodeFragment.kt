package com.example.tbc_test6.presentation.passcode

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tbc_test6.R
import com.example.tbc_test6.data.common.InputButton
import com.example.tbc_test6.databinding.FragmentPasscodeBinding
import com.example.tbc_test6.presentation.BaseFragment
import com.example.tbc_test6.presentation.passcode.rv_adapters.InputsRecyclerAdapter


class PasscodeFragment : BaseFragment<FragmentPasscodeBinding>(FragmentPasscodeBinding::inflate) {

    private val viewModel: PasscodeFragmentViewModel by viewModels()
    private lateinit var inputsAdapter: InputsRecyclerAdapter

    override fun setUp() {
        setUpInputRv()
    }

    private fun setUpInputRv() {
        binding.rvInputs.layoutManager = GridLayoutManager(context, 3)
        inputsAdapter = InputsRecyclerAdapter()
        inputsAdapter.apply{
            submitList(setUpInputs())
            itemOnClick = {}
        }
        binding.rvInputs.adapter = inputsAdapter
    }

    private fun setUpBallsRv() {

    }

    private fun setUpInputs(): List<InputButton> {
        val list = mutableListOf<InputButton>()
        for (i in 0..8) {
            list.add(i, InputButton(i, "${i+1}", null))
        }
        list.add(9, InputButton(9, null, R.drawable.ic_fingerprint))
        list.add(10, InputButton(10, "0", null))
        list.add(11, InputButton(11, null, R.drawable.ic_delete))
        return list
    }

}