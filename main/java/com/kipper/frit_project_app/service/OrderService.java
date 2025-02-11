package com.kipper.frit_project_app.service;

import com.kipper.frit_project_app.entities.Order;
import com.kipper.frit_project_app.entities.dto.OrderDTO;
import com.kipper.frit_project_app.entities.dto.OrderItemDTO;
import com.kipper.frit_project_app.entities.dto.PaymentDTO;
import com.kipper.frit_project_app.repositories.OrderRepository;
import com.kipper.frit_project_app.repositories.UserRepository;
import com.kipper.frit_project_app.service.exception.HttpMessageNotReadableException;
import com.kipper.frit_project_app.service.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<OrderDTO> findAll() {
        return repository.findAll().stream().map(
                order -> new OrderDTO(order)
        ).toList();
    }

//      return repository.findAll().stream().map(
//            user -> new UserDTO(user.getName(), user.getEmail(), user.getPhone(), user.getRole())).toList();
    public Order findById(Long id) {
        try{
            if(!repository.existsById(id)){
               throw new NoSuchElementException(id.toString());
            }
            if(id == null || id <= 0) {
                throw new HttpMessageNotReadableException(id.toString());
            }

        }catch (ResourceNotFoundException e ){
            throw new ResourceNotFoundException(id);
        }
        catch (NoSuchElementException e ){
            throw new NoSuchElementException(e.getMessage());
        }
        catch (Exception e ){
            e.printStackTrace();
            }
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}
