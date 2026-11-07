package com.example.studentapp.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.studentapp.databinding.FragmentStudentDetailBinding

class StudentDetailFragment : Fragment() {

    private var _binding: FragmentStudentDetailBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_NAME = "arg_name"
        private const val ARG_ID = "arg_id"
        private const val ARG_EMAIL = "arg_email"
        private const val ARG_PHONE = "arg_phone"

        // Hàm giúp truyền dữ liệu vào Fragment an toàn qua Bundle
        fun newInstance(name: String, id: String, email: String, phone: String): StudentDetailFragment {
            val fragment = StudentDetailFragment()
            val args = Bundle().apply {
                putString(ARG_NAME, name)
                putString(ARG_ID, id)
                putString(ARG_EMAIL, email)
                putString(ARG_PHONE, phone)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Nhận dữ liệu truyền từ StudentListFragment sang
        arguments?.let {
            binding.tvDetailName.text = it.getString(ARG_NAME)
            binding.tvDetailId.text = "Mã sinh viên: ${it.getString(ARG_ID)}"
            binding.tvDetailEmail.text = "Email: ${it.getString(ARG_EMAIL)}"
            binding.tvDetailPhone.text = "Số điện thoại: ${it.getString(ARG_PHONE)}"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}