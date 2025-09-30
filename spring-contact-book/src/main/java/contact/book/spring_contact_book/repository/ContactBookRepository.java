package contact.book.spring_contact_book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import contact.book.spring_contact_book.model.ContactBookModel;

public interface ContactBookRepository extends JpaRepository<ContactBookModel, Long> {

    List<ContactBookModel> findByName(String name);

    List<ContactBookModel> findByEmail(String email);

}
