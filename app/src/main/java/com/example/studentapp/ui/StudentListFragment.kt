package com.example.studentapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.studentapp.R
import com.example.studentapp.databinding.FragmentStudentListBinding

class StudentListFragment : Fragment() {

    private var _binding: FragmentStudentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Bấm nút để chuyển thẳng sang Fragment chi tiết sinh viên
        binding.btnGoToDetail.setOnClickListener {
            // Tạo Fragment chi tiết và truyền dữ liệu mẫu qua arguments
            val detailFragment = StudentDetailFragment.newInstance(
                "Phạm Duy Hưng",
                "2415053122116",
                "2415053122116@ute.edu.vn",
                "0905123456"
            )

            // Thực hiện chuyển đổi Fragment (thay thế và cho phép bấm Back quay lại)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}