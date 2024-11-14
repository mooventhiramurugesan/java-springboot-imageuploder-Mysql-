package com.DemoImageUploder.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.DemoImageUploder.Entity.Files;

public interface FileRepository extends JpaRepository<Files,Integer>
{
       Files findByName(String name);
}
